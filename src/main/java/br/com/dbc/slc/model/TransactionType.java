package br.com.dbc.slc.model;

public enum TransactionType {

    CREDIT("C"),
    DEBIT("D");

    private String abbreviation;

    private TransactionType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public TransactionType valueOfAbbreviation(String abbreviation) {
        for (TransactionType type : TransactionType.values()) {
            if (type.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return type;
            }
        }
        return null;
    }

}
