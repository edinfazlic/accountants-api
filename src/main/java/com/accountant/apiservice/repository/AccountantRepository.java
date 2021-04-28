/*
 * This file is part of the MedRecord Serious Gaming Service which is commercial software
 * created by MedVision360 B.V. The source code is proprietary and confidential.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * Copyright (c) by MedVision360 B.V. All rights reserved.
 */

package com.accountant.apiservice.repository;

import com.accountant.apiservice.model.entities.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountantRepository extends JpaRepository<Accountant, Long> {

  Collection<Accountant> findByActive(boolean active);

}
