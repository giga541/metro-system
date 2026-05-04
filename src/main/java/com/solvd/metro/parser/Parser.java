package com.solvd.metro.parser;

import com.solvd.metro.model.MetroSystemDto;

public interface Parser {
    MetroSystemDto parse(String filePath) throws Exception;
}