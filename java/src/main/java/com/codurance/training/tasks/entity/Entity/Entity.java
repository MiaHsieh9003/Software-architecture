package com.codurance.training.tasks.Entity.Entity;

import java.io.Serializable;

public interface Entity<ID> extends Serializable {
    ID getID();
}
