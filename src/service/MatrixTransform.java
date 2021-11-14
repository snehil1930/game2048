package service;

import enums.Direction;

import java.util.ArrayList;

public class MatrixTransform {

    public int[][] makeMove(int [][] board, Direction direction){

        int n=board.length;
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        if (direction==Direction.RIGHT) {
            for (int i = 0; i < n; i++) {
                v=new ArrayList<>();
                w=new ArrayList<>();
                for (int j = 0 ;j <n; j++) {
                    if (board[i][j] != 0)
                        v.add(board[i][j]);
                }
                for (int j = 0; j < v.size(); j++) {
                    if (j < v.size() - 1 && v.get(j) == v.get(j + 1)) {
                        w.add(2 * v.get(i));
                        j++;
                    }
                    else
                        w.add(v.get(j));
                }
                for (int j = 0; j < n; j++)
                    board[i][j] = 0;
                int j = n - 1;
                for (Integer it:w)
                    board[i][j--]=it;
            }
        }

        // for left shift move
        else if (direction == Direction.LEFT) {
            for (int i = 0; i < n; i++) {
                int j;

                for (j = 0; j < n; j++) {
                    if (board[i][j] != 0)
                        v.add(board[i][j]);
                }
                for (j = 0; j < v.size(); j++) {

                    if (j < v.size() - 1 && v.get(j) == v.get(j + 1)) {
                        w.add(2 * v.get(j));
                        j++;
                    }
                    else
                        w.add(v.get(j));
                }

                for (j = 0; j < n; j++)
                    board[i][j] = 0;

                j = 0;

                for (int it:w)
                    board[i][j++] = it;
            }
        }

        // for down shift move.
        else if (direction == Direction.DOWN) {
            // for each column
            for (int i = 0; i < n; i++) {
                int j;

                for (j = n - 1; j >= 0; j--) {
                    // if not 0
                    if (board[j][i] != 0)
                        v.add(board[j][i]);
                }

                // for each temporary array
                for (j = 0; j < v.size(); j++) {

                    // if two element have
                    // same value at consecutive
                    // position.
                    if (j < v.size() - 1 && v.get(j) == v.get(j + 1)) {
                        // insert only one element
                        // as sum of two same element.
                        w.add(2 * v.get(j));
                        j++;
                    }
                    else
                        w.add(v.get(j));
                }

                // filling the each
                // column element to 0.
                for (j = 0; j < n; j++)
                    board[j][i] = 0;

                j = n - 1;

                // Copying the temporary array
                // to the current column
                for (int it:w)
                    board[j--][i] = it;
            }
        }

        // for up shift move
        else if (direction == Direction.UP) {
            // for each column
            for (int i = 0; i < n; i++) {
                int j;

                // for each element of column
                // from top to bottom
                for (j = 0; j < n; j++) {
                    // if not 0
                    if (board[j][i] != 0)
                        v.add(board[j][i]);
                }

                // for each temporary array
                for (j = 0; j < v.size(); j++) {
                    // if two element have
                    // same value at
                    // consecutive position.
                    if (j < v.size() - 1 && v.get(j) == v.get(j + 1)) {
                        // insert only one element
                        // as sum of two same element.
                        w.add(2 * v.get(j));
                        j++;
                    }
                    else
                        w.add(v.get(j));
                }

                // filling the each
                // column element to 0.
                for (j = 0; j < n; j++)
                    board[j][i] = 0;

                j = 0;

                // Copying the temporary
                // array to the current
                // column
                for (int it = 0; it < w.size(); it++)
                    board[j++][i] = w.get(it);
            }
        }

        return board;
    }
}
