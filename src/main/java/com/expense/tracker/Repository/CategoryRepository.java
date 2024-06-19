package com.expense.tracker.Repository;

import com.expense.tracker.Model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}
