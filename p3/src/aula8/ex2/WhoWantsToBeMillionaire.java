package aula8.ex2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WhoWantsToBeMillionaire extends JFrame {
    private static final int[] values = {25, 50, 125, 250, 500, 750, 1500, 2500, 5000, 10000, 16000, 32000, 64000, 125000, 250000};
    private int i;
    private int prize;
    private Question[] questions;
    private boolean fiftyFifty;
    private boolean call;
    private boolean viewers;

    public WhoWantsToBeMillionaire() {
        readQuestionsFromFile();
        this.fiftyFifty = false;
        this.call = false;
        this.viewers = false;
        this.i = 0;
        this.prize = 0;
    }

    public Question getQuestion() {
        return questions[i];
    }

    public int getQuestionNumber() {
        return this.i;
    }

    public boolean checkAnswer(String answer) {
        if (answer == null)
            throw new IllegalArgumentException("Resposta inválida");
        if (answer.equals(questions[i].getAnswers()[questions[i].getCorrectAnswer()])) {
            prize = values[i++];
            return true;
        }
        return false;
    }

    public int getPrize() {
        return this.prize;
    }

    public int[] useFiftyFifty() {
        if (fiftyFifty)
            throw new AssertionError("Não se pode utilizar duas vezes a mesma ajuda");

        fiftyFifty = true;
        return internalChoice();
    }

    public int[][] useCallHelp() {
        if (call)
            throw new AssertionError("Não se pode utilizar duas vezes a mesma ajuda");

        call = true;

        Random r = new Random();
        int[] indexes = internalChoice();
        int[][] to_return = new int[2][2];

        to_return[0][0] = indexes[0];
        to_return[0][1] = r.nextInt(20) + 50 - 2 * i;
        to_return[1][0] = indexes[1];
        to_return[1][1] = 100 - to_return[0][1];

        return to_return;
    }

    public int[] useViewersHelp() {
        if (viewers)
            throw new AssertionError("Não se pode utilizar duas vezes a mesma ajuda");

        viewers = true;
        int[] to_return = new int[4];
        Random r = new Random();
        int sum = 0;

        for (int j = 0; j < 3; j++) {
            if (j == questions[i].getCorrectAnswer())
                to_return[j] = r.nextInt(20) + 40 - 2 * i;
            else
                to_return[j] = r.nextInt(20);
            sum += to_return[j];
        }

        to_return[3] = 100 - sum;

        return to_return;
    }

    private void readQuestionsFromFile() {
        Path p = Paths.get("gp8_files/QQSM/questionsfinal.txt");
        java.util.List<Question> list = new ArrayList<Question>();
        try (BufferedReader bf = Files.newBufferedReader(p)) {
            String line;
            int j = 0;
            while ((line = bf.readLine()) != null) {
                String info[] = line.split("\\&+");
                if (info.length != 7)
                    throw new IllegalArgumentException("Ficheiro inválido");
                list.add(new Question(values[j++], info[1], Arrays.copyOfRange(info, 2, 6), Integer.parseInt(info[6]), Paths.get(info[0])));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
        questions = list.toArray(new Question[list.size()]);
    }

    private int[] internalChoice() {
        Random r = new Random();
        int n;
        int[] to_return = {questions[i].getCorrectAnswer(), -2};

        while (true) {
            n = r.nextInt(4);
            if (n != questions[i].getCorrectAnswer()) {
                to_return[1] = n;
                break;
            }
        }
        return to_return;
    }


}
