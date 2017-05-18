package com.solutionsiq.computers.monadic.springboot.services;

import com.solutionsiq.computers.monadic.springboot.services.definition.ComputerService;

public class SquarerService implements ComputerService {

    public long compute(long monadicArgument) {
        return monadicArgument*monadicArgument;
    }

}