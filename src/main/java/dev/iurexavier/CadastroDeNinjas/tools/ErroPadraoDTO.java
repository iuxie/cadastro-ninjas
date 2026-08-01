package dev.iurexavier.CadastroDeNinjas.tools;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroPadraoDTO {

    @Schema(description = "Timestamp do erro", example = "2026-08-01T09:19:58Z")
    private String timestamp;

    @Schema(description = "Status HTTP", example = "404")
    private Integer status;

    @Schema(description = "Mensagem do erro", example = "Recurso não encontrado")
    private String error;

}
