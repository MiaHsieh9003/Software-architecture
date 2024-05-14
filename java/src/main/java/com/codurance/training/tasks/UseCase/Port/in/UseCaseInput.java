package com.codurance.training.tasks.UseCase.Port.in;

public interface UseCaseInput {
    static NullUseCaseInput nullInput(){
        return new NullUseCaseInput();
    }
}
