package com.accountant.apiservice.controller;

import com.accountant.apiservice.model.dto.AccountantDto;
import com.accountant.apiservice.service.AccountantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

  AccountantService service;

  public AccountantController(final AccountantService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Collection<AccountantDto>> list(
      @RequestParam(required = false) Boolean employed,
      @RequestParam(required = false) String name
  ) {
    Collection<AccountantDto> accountants = service.getList(employed, name);

    return ResponseEntity.status(HttpStatus.OK).body(accountants);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountantDto> get(
      @PathVariable Long id
  ) {
    AccountantDto accountant = service.get(id);

    return ResponseEntity.status(HttpStatus.OK).body(accountant);
  }

  @PostMapping
  public ResponseEntity<AccountantDto> save(
      @RequestBody AccountantDto accountant
  ) {
    AccountantDto result = service.save(accountant);

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AccountantDto> update(
      @PathVariable Long id,
      @RequestBody AccountantDto accountant
  ) {
    AccountantDto result = service.update(id, accountant);

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<AccountantDto> update(
      @PathVariable Long id
  ) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
