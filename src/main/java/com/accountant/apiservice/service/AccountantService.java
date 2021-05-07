package com.accountant.apiservice.service;

import com.accountant.apiservice.model.dto.AccountantDto;
import com.accountant.apiservice.model.entities.Accountant;
import com.accountant.apiservice.repository.AccountantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountantService {

  private final AccountantRepository accountantRepository;

  public Collection<AccountantDto> getList(Boolean employed, String name) {
    // todo: proper filtering
    return accountantRepository.findAll().stream()
        .map(this::toPayload)
        .collect(Collectors.toList());
  }

  public AccountantDto get(Long id) {
    Optional<Accountant> accountantOptional = accountantRepository.findById(id);
    if (accountantOptional.isPresent()) {
      return toPayload(accountantOptional.get());
    }
    throw new RuntimeException("Accountant with id:" + id + " doesn't exist!");
  }

  public AccountantDto save(AccountantDto payload) {
    Accountant accountant = fromPayload(payload);
    accountant = accountantRepository.save(accountant);
    return toPayload(accountant);
  }

  public AccountantDto update(Long id, AccountantDto payload) {
    get(id);

    Accountant accountant = fromPayload(payload);
    accountant.setId(id);
    accountant = accountantRepository.save(accountant);
    return toPayload(accountant);
  }

  public void delete(Long id) {
    accountantRepository.deleteById(id);
  }

  private Accountant fromPayload(AccountantDto payload) {
    Accountant accountant = new Accountant();
    accountant.setActive(payload.getEmployed());
    accountant.setName(payload.getName());
    return accountant;
  }

  private AccountantDto toPayload(Accountant accountant) {
    AccountantDto payload = new AccountantDto();
    payload.setEmployed(accountant.isActive());
    payload.setName(accountant.getName());
    payload.setId(accountant.getId());
    return payload;
  }
}
