package com.accountant.apiservice.service;

import com.accountant.apiservice.model.Accountant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountantService {

  private ArrayList<Accountant> accountants = new ArrayList<>();

  public AccountantService() {
    accountants.add(new Accountant(0L, "Mike", true));
    accountants.add(new Accountant(1L, "Jane", true));
    accountants.add(new Accountant(2L, "Bob", false));
    accountants.add(new Accountant(3L, "Lara", false));
  }

  public List<Accountant> getList(Boolean employed) {
    return this.accountants.stream()
        .filter(accountant -> employed == null ||  employed == accountant.getEmployed())
        .collect(Collectors.toList());
  }

  public Accountant get(Long id) {
    if (id == null) {
      return null;
    }
    for (Accountant accountant : accountants) {
      if (id.equals(accountant.getId())) {
        return accountant;
      }
    }

    return null;
  }

  public Accountant save(Accountant accountant) {
    accountants.add(accountant);
    return accountant;
  }

  public Accountant update(Long id, Accountant accountant) {
    if (id == null) {
      return null;
    }

    for (Accountant existingAccountant : accountants) {
      if (id.equals(existingAccountant.getId())) {
        existingAccountant.setId(accountant.getId());
        existingAccountant.setName(accountant.getName());
        return existingAccountant;
      }
    }

    return null;
  }

  public void delete(Long id) {
    if (id == null) {
      return;
    }

    // todo: complete this method

//    for (Accountant existingAccountant : accountants) {
//      if (id.equals(existingAccountant.getId())) {
//        existingAccountant.setId(accountant.getId());
//        existingAccountant.setName(accountant.getName());
//        return existingAccountant;
//      }
//    }
//
//    return null;
  }
}
