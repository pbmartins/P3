package aula8.ex2;

import java.nio.file.*;
import java.util.*;

public class Question {
    private int value;
    private String question;
    private String[] answers;
    private int correctAnswer;
    private Path image;

    public Question(int value, String question, String[] answers, int correctAnswer, Path image) {
        if (value <= 0)
            throw new IllegalArgumentException("Valor inválido");
        if (question == null || question.length() == 0)
            throw new IllegalArgumentException("Questão inválida");
        if (answers == null || answers.length < 2 || answers.length > 4)
            throw new IllegalArgumentException("Respostas inválidas");
        if (correctAnswer < 0 || correctAnswer > 4)
            throw new IllegalArgumentException("Resposta correta inválida");
        if (image == null)
            throw new IllegalArgumentException("Caminho para a imagem inválido");

        this.value = value;
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.image = image;
    }

    public int getValue() {
        return this.value;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public Path getImage() {
        return this.image;
    }

    public boolean equals(Object q) {
        if (q == null)
            return false;
        if (q.getClass() != this.getClass())
            return false;
        return this.value == ((Question)q).getValue() && ((Question)q).getQuestion().equals(this.question) && Arrays.equals(((Question)q).getAnswers(), this.answers)
            && ((Question)q).getCorrectAnswer() == this.correctAnswer && ((Question)q).getImage().equals(this.image);
    }

    public String toString() {
        String to_return =  "Valor: " + this.value +
                            "\nPergunta: " + this.question +
                            "\nRespostas: ";

        for (String s : this.answers)
            to_return += "\n\t" + s;

        to_return += "\nResposta correta: " + this.correctAnswer +
                     "\nImagem: " + this.image.toString();
        return to_return;
    }
}

