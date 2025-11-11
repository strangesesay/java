package com.strangeTech.Wirent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepo extends JpaRepository<TenantRepo,Long> {
}
