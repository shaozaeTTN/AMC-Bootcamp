package com.aem.training.core.pojo;

import com.aem.training.core.services.BlogApi;

/* POJO class that aids in sorting (natural order)
*/
public class Blog implements BlogApi, Comparable<Blog>{
    private int Rank;
    private String BlogCategory;

    public Blog(int blogRank, String category){
        Rank = blogRank;
        BlogCategory = category;
    }

    @Override
    public String getBlogCategory() {
        return BlogCategory;
    }

    @Override
    public Integer getRank() {
        return Rank;
    }

    // Defining natural sorting order
    @Override
    public int compareTo(Blog blog) {
        return this.BlogCategory.compareToIgnoreCase(blog.BlogCategory);
    }

    @Override
    public String toString() {
        return "Category: " + BlogCategory + " || " + "Rank: " + Rank;
    }
}
