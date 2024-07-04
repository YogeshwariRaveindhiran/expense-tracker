package com.expense.tracker.DTO;

import java.util.List;

public class ComparisonReportDTO {

    private List<CategoryComparisonDTO> categoryComparisons;

    public ComparisonReportDTO(List<CategoryComparisonDTO> categoryComparisons) {
        this.categoryComparisons = categoryComparisons;
    }

    public List<CategoryComparisonDTO> getCategoryComparisons() {
        return categoryComparisons;
    }

    public void setCategoryComparisons(List<CategoryComparisonDTO> categoryComparisons) {
        this.categoryComparisons = categoryComparisons;
    }
}
