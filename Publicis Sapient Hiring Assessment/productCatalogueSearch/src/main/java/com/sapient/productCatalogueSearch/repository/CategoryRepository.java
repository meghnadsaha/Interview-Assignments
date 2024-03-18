package com.sapient.productCatalogueSearch.repository;

import com.sapient.productCatalogueSearch.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
