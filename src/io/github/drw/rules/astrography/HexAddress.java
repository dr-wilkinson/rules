package io.github.drw.rules.astrography;

/**
 * The address of a {@link Hexector}.
 *
 * @author dr-wilkinson
 */
class HexAddress {

    private final String column;
    private final String row;

    /**
     * Constructs a new HexAddress using the supplied column and row.
     *
     * @param column The column aspect.
     * @param row The row aspect.
     */
    HexAddress(String column, String row) {
        this.column = column;
        this.row = row;
    }

    /**
     * Returns this HexAddress's column.
     *
     * @return The column.
     */
    String getColumn() {
        return column;
    }

    /**
     * Returns this HexAddress's row.
     *
     * @return The row.
     */
    String getRow() {
        return row;
    }

    /**
     * Returns this HexAddress offset by the supplied column and row.
     *
     * @param column The column to offset by.
     * @param row The row to offset by.
     * @return The offset HexAddress.
     */
    HexAddress offset(int column, int row) {
        int c = Integer.parseInt(this.column) + column;
        int r = Integer.parseInt(this.row) + row;
        return new HexAddress(String.valueOf(c), String.valueOf(r));
    }

    /**
     * Returns a textual view of this HexAddress.
     *
     * @return The textual view of this HexAddress.
     */
    String asText() {
        StringBuilder sb = new StringBuilder();
        sb.append(column);
        sb.append(row);
        return sb.toString();
    }

}
