package com.accountant.apiservice.controller;

import com.accountant.apiservice.model.Accountant;
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

import java.util.List;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

  AccountantService service;

  public AccountantController(final AccountantService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Accountant>> list(
      @RequestParam(required = false) Boolean employed
  ) {
    List<Accountant> accountants = service.getList(employed);

    return ResponseEntity.status(HttpStatus.OK).body(accountants);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Accountant> get(
      @PathVariable Long id
  ) {
    Accountant accountant = service.get(id);

    return ResponseEntity.status(HttpStatus.OK).body(accountant);
  }

  @PostMapping
  public ResponseEntity<Accountant> save(
      @RequestBody Accountant accountant
  ) {
    Accountant result = service.save(accountant);

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Accountant> update(
      @PathVariable Long id,
      @RequestBody Accountant accountant
  ) {
    Accountant result = service.update(id, accountant);

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Accountant> update(
      @PathVariable Long id
  ) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}

/*

Read      GET
Create    POST

Update    PUT
Delete    DELETE

*/
