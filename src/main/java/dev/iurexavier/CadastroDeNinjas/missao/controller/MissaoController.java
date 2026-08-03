package dev.iurexavier.CadastroDeNinjas.missao.controller;

import dev.iurexavier.CadastroDeNinjas.missao.dto.MissaoDTO;
import dev.iurexavier.CadastroDeNinjas.missao.service.MissaoService;
import dev.iurexavier.CadastroDeNinjas.missao.service.model.MissaoModel;
import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.tools.ApiErrosGlobais;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@Tag(name = "Missões", description = "Endpoints para gerenciamento de missões")
@ApiErrosGlobais
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as Missões", description = "Rota responsável por listar todas as missões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MissaoDTO.class)
                    )),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content)
    })
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missaoDTOList = service.listarMissoes();
        if (!missaoDTOList.isEmpty()) {
            return ResponseEntity.ok()
                    .body(missaoDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar Missão por ID", description = "Rota responsável por listar uma Missão pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MissaoDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<MissaoDTO> procurarMissaoPorId(
            @Parameter(description = "ID da Missão", example = "255", required = true)
            @PathVariable Long id) {
        MissaoDTO missaoDTO = service.procurarMissaoPorId(id);
        if (missaoDTO != null) {
            return ResponseEntity.ok()
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova Missão",description = "Rota responsável por criar uma nova Missão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MissaoDTO.class)
                    ))
    })
    public ResponseEntity<MissaoDTO> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO missaoDTO = service.criarMissao(missao);
        if (missaoDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma Missão", description = "Rota responsável por atualizar uma Missão pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MissaoDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<MissaoDTO> atualizarMissao(
            @Parameter(description = "ID da Missão", example = "255", required = true)
            @PathVariable Long id, @RequestBody MissaoDTO missao) {
        MissaoDTO missaoDTO = service.atualizarMissao(id, missao);
        if (missaoDTO != null) {
            return ResponseEntity.ok()
                    .body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma Missão", description = "Rota responsável por deletar uma Missão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<Void> deletarMissao(
            @Parameter(description = "ID da Missão", example = "255", required = true)
            @PathVariable Long id) {
        if (service.procurarMissaoPorId(id) != null) {
            service.deletarMissao(id);
            return ResponseEntity.noContent()
                    .build();
        }
       return ResponseEntity.notFound()
               .build();
    }

}
