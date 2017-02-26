package com.gs.reusebook.controller;

import static com.gs.reusebook.util.ReusebookStatic.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Evaluation;
import com.gs.reusebook.service.EvaluationService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	@Autowired
	private EvaluationService evaluationService;
	
	/**
	 * 添加一条评论
	 * @param evaluation
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@NeedUserLogin
	public UiReturn add(@RequestBody Evaluation evaluation, HttpSession session){
		// TODO 参数校验
		String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
		return evaluationService.addEvaluation(userId, evaluation.getGoodsId(), evaluation.getContent());
	}
	
	/**
	 * 获取某商品的全部评论
	 * @param evaluation
	 * @return
	 */
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	@ResponseBody
	public UiReturn selectAll(@RequestBody Evaluation evaluation){
		// TODO 参数校验
		return evaluationService.selectAll(evaluation.getGoodsId());
	}
}
