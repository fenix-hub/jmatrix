package com.fenixhub.matrix.classes;

public class LongMatrix extends GenericMatrix<Long> {

    @Override
    public Class<Long> getClazz() {
        return Long.class;
    }

    @Override
    protected String getFormat() {
        return "%"+getFormatPaddings()+"d";
    }

    public LongMatrix() {
        super(Long.class);
    }

    public LongMatrix(int nRows, int nColumns) {
        super(nRows, nColumns, Long.class);
    }

    public LongMatrix(Long[][] array) {
        super(array);
    }

}
