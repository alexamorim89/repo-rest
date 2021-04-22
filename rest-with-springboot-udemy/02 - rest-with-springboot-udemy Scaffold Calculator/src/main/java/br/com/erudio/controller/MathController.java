 package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exception.OperationNotSupportedExpcetion;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");
		}
		return SimpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));		
	}
	
	@RequestMapping(value = "subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double  subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");	
		}
		return SimpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double  multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");	
		}
		return SimpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double  division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");	
		}
		return SimpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double  average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");	
		}
		return SimpleMath.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
	public Double  squareRoot(@PathVariable("number") String number) {
		if(!NumberConverter.isNumeric(number)) {
			throw new OperationNotSupportedExpcetion("favor defina um valor numerico");	
		}
		return SimpleMath.squareRoot(NumberConverter.convertToDouble(number));
	}
	
}