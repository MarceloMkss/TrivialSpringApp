package com.infotek.trivial.aplication.dominio;

import java.util.Arrays;

public class Question {

    private String category;
    private String question;
    private String[] options;
    private Integer answer;
    private String explanation;
    
	public Question() {
		super();
	}
	public Question(String category, String question, String[] options, Integer answer, String explanation) {
		super();
		this.category = category;
		this.question = question;
		this.options = options;
		this.answer = answer;
		this.explanation = explanation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "Question [category=" + category + ", question=" + question + ", options=" + Arrays.toString(options)
				+ ", answer=" + answer + ", explanation=" + explanation + "]";
	}		
					
}
