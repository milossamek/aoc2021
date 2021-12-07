package com.milossamek.aoc2021.solutions.day4;

import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import com.milossamek.aoc2021.solutions.day4.model.BingoNumber;
import com.milossamek.aoc2021.solutions.day4.model.Board;
import com.milossamek.aoc2021.solutions.day4.model.GameBoard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class GiantSquidBingoCalculator extends ResourceLoader<GameBoard> implements Calculator<GameBoard> {

    @Override
    public long calculate(List<GameBoard> input) {
        //we have always only one game board
        final GameBoard gameBoard = input.get(0);
        final AtomicReference<Board> winningBoard = new AtomicReference<>();
        final List<Integer> numbers = gameBoard.getDrawnNumbers();
        final Optional<Integer> winningNumber = numbers.stream().filter(number -> {
            final Optional<Board> wBoard = getWinningBoard(gameBoard, number);
            if (wBoard.isPresent()) {
                winningBoard.set(wBoard.get());
                return true;
            }
            return false;
        }).findFirst();
        return (long) winningBoard.get().getSumOfAllNotDrawnNumbers() * winningNumber.orElse(0);
    }

    private Optional<Board> getWinningBoard(GameBoard gameBoard, int number) {
        return gameBoard.getBoards().stream().filter(board -> {
            board.setBingoNumber(number);
            return board.hasBingo();
        }).findFirst();
    }

    @Override
    public Collection<GameBoard> map(Stream<String> lines) {
        final GameBoard gameBoard = new GameBoard();
        final List<String> linesList = lines.toList();
        gameBoard.setDrawnNumbers(Arrays.stream(linesList.get(0).split(",")).map(Integer::parseInt).toList());
        AtomicReference<Board> board = new AtomicReference<>(new Board());
        linesList.stream().skip(1).forEach(line -> processBoardLines(gameBoard, board, line));
        return Collections.singletonList(gameBoard);
    }

    private void processBoardLines(GameBoard gameBoard, AtomicReference<Board> board, String line) {
        if (line.trim().equalsIgnoreCase("")) {
            createNewBoard(gameBoard, board);
        } else {
            appendLineToBoard(board, line);
        }
    }

    private void createNewBoard(GameBoard gameBoard, AtomicReference<Board> board) {
        board.set(new Board());
        gameBoard.getBoards().add(board.get());
    }

    private void appendLineToBoard(AtomicReference<Board> board, String line) {
        board.get().getNumbers().add(Arrays.stream(line.split(" ")).filter(number -> !number.trim().equalsIgnoreCase("")).map(number -> new BingoNumber(Integer.parseInt(number))).toList());
    }
}
