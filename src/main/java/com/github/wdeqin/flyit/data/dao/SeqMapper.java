package com.github.wdeqin.flyit.data.dao;

import com.github.wdeqin.flyit.data.model.Seq;

public interface SeqMapper {
    int nxtVal(Seq record);
}