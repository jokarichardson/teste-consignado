package com.richardson.consignado.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardson.consignado.application.ConsignadoApplication;
import com.richardson.consignado.config.SwaggerConfig;
import com.richardson.consignado.model.dto.CreditoContratadoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/consignado")
@Validated
@Api(tags = { SwaggerConfig.CONTROLLER_TAG })
public class ConsignadoController {

	private static final Logger log = LoggerFactory.getLogger(ConsignadoController.class);
	
	@Autowired
	private ConsignadoApplication consignadoApplication;

	@ApiOperation(value = "Recuperar Ofertas: DDB <= Data Atual - 180 dias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Iterable.class),
			@ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure", response = Exception.class) })
	@GetMapping(value = "/recuperarOfertas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> recuperarOfertas() {
		log.info("recuperarOfertas()");
		
		try {
			return new ResponseEntity<>(this.consignadoApplication.recuperarOfertas(), HttpStatus.OK);
		} catch (Exception ex) {
            log.error("Não foi possível atender a requisição", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@ApiOperation(value = "Recuperar Ofertas Autorizadas: (DAC - DDB) >= 90 dias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Iterable.class),
			@ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure", response = Exception.class) })
	@GetMapping(value = "/recuperarOfertasAutorizadas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> recuperarOfertasAutorizadas() {
		log.info("recuperarOfertasAutorizadas()");
		
		try {
			return new ResponseEntity<>(this.consignadoApplication.recuperarOfertasAutorizadas(), HttpStatus.OK);
		} catch (Exception ex) {
            log.error("Não foi possível atender a requisição", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Armazenar Dados para Contratação do Crédito")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = CreditoContratadoDTO.class),
			@ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure", response = Exception.class) })
	@PostMapping
	public ResponseEntity<Object> armazenarCreditoContratado(@RequestBody @Valid CreditoContratadoDTO creditoContratadoDTO) {
		log.info("armazenarCreditoContratado() {}", creditoContratadoDTO.toString());
		
		try {
			return new ResponseEntity<>(this.consignadoApplication.armazenarConsignado(creditoContratadoDTO), HttpStatus.CREATED);
		} catch (Exception ex) {
            log.error("Não foi possível atender a requisição", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
