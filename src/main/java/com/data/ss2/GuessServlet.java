package com.data.ss2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;
@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    private final String[] wordList = {"love", "school", "true", "false", "oke"};

    private String getRandomWord() {
        Random rand = new Random();
        return wordList[rand.nextInt(wordList.length)];
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String hiddenWord = getRandomWord();
        session.setAttribute("hiddenWord", hiddenWord);
        session.setAttribute("attemptsLeft", 5);
        session.setAttribute("message", "");
        session.setAttribute("displayHint", getHint(hiddenWord)); // Hiển thị gợi ý từ với vài chữ

        request.getRequestDispatcher("guess.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String hiddenWord = (String) session.getAttribute("hiddenWord");
        int attemptsLeft = (int) session.getAttribute("attemptsLeft");
        String guess = request.getParameter("guess");

        if (guess != null && !guess.trim().isEmpty()) {
            guess = guess.trim().toLowerCase();
            if (guess.equals(hiddenWord)) {
                session.setAttribute("message", "🎉 Chúc mừng! Bạn đã đoán đúng từ: " + hiddenWord);
            } else {
                attemptsLeft--;
                if (attemptsLeft <= 0) {
                    session.setAttribute("message", "❌ Bạn đã thua! Từ đúng là: " + hiddenWord);
                } else {
                    session.setAttribute("message", "Sai rồi! Hãy thử lại.");
                }
            }
        }

        session.setAttribute("attemptsLeft", attemptsLeft);

        // giữ lại gợi ý
        session.setAttribute("displayHint", getHint(hiddenWord));

        request.getRequestDispatcher("guess.jsp").forward(request, response);
    }

    // Gợi ý: hiện một vài chữ trong từ
    private String getHint(String word) {
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        boolean[] revealed = new boolean[word.length()];

        // hiện ngẫu nhiên 2 chữ
        int count = 0;
        while (count < 2) {
            int i = rand.nextInt(word.length());
            if (!revealed[i]) {
                revealed[i] = true;
                count++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (revealed[i]) {
                result.append(word.charAt(i));
            } else {
                result.append("_");
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
