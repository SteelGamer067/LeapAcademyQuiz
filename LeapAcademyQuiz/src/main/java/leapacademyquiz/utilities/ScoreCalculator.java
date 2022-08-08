package leapacademyquiz.utilities;

import java.util.ArrayList;

import leapacademyquiz.dal.LeapAcademyQuizDAO;

public class ScoreCalculator {
	LeapAcademyQuizDAO laqDAO = new LeapAcademyQuizDAO();
	private int questionTotal = 10;
	private float questionScore = 0.0f;
	
	public float calculateQuestionScore(ArrayList<Boolean> choices, ArrayList<Boolean> answers, int correctAnswers) {
		float fraction = questionTotal/(correctAnswers * 1.0f);
		for(int i = 0; i < answers.size(); i++) {
			if(choices.get(i) == answers.get(i)) {
				if(answers.get(i)) questionScore += fraction;
				else continue;
			}
			else questionScore--;
		}
		return questionScore;
	}
	
	/*public static void main(String[] args) {
		ArrayList<Boolean> choices = new ArrayList<Boolean>();
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		int c = 0;
		
		choices.add(false); answers.add(false);
		choices.add(false); answers.add(true);
		choices.add(false); answers.add(false);
		choices.add(true); answers.add(true);
		
		for(int i = 0; i < answers.size(); i++) {
			if(answers.get(i)) c++;
			System.out.println(answers.get(i) + " " + answers.size() + " " + c);
		}
		
		ScoreCalculator sc = new ScoreCalculator();
		System.out.println(sc.calculateQuestionScore(choices, answers, c));
	}*/
}
