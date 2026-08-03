package dev.iurexavier.CadastroDeNinjas.ninjas.controller;

import dev.iurexavier.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import dev.iurexavier.CadastroDeNinjas.ninjas.service.NinjaService;
import dev.iurexavier.CadastroDeNinjas.tools.ApiErrosGlobais;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
@RequestMapping("/ninjas")
@Tag(name = "Ninjas", description = "Endpoints para o gerenciamento de Ninjas")
@ApiErrosGlobais
public class NinjaController {

    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Criar um novo Ninja",description = "Rota responsável por criar um novo Ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NinjaDTO.class)
                    ))
    })
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = service.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    @GetMapping
    @Operation(summary = "Listar todos os Ninjas", description = "Rota responsável por listar todos os Ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = NinjaDTO.class))
            )),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content)
    })
    public ResponseEntity<List<NinjaDTO>> listarNinja() {
        List<NinjaDTO> ninjaList = service.listarNinjas();
        if (!ninjaList.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ninjaList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar Ninja por ID", description = "Rota responsável por listar um Ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NinjaDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<NinjaDTO> listarNinjaPorId(
            @Parameter(description = "ID do Ninja", example = "155", required = true)
            @PathVariable Long id) {
        NinjaDTO ninjaDTO = service.listarNinjaPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok()
                    .body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um Ninja", description = "Rota responsável por atualizar um Ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NinjaDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<NinjaDTO> atualizarNinja(
            @Parameter(description = "ID do Ninja", example = "155", required = true)
            @PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAtualizado = service.atualizarNinja(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok()
                    .body(ninjaAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um Ninja", description = "Rota responsável por deletar um Ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public ResponseEntity<Void> deletarNinja(
            @Parameter(description = "ID do Ninja", example = "155", required = true)
            @PathVariable Long id) {
        if (service.listarNinjaPorId(id) != null) {
            service.deletarNinjaPorId(id);
            return ResponseEntity.noContent()
                    .build();
        }
        return ResponseEntity.notFound()
                .build();
    }

}
