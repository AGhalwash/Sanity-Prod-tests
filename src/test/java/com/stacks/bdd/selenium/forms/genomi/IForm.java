package com.stacks.bdd.selenium.forms.genomi;

import java.util.List;

import com.stacks.bdd.selenium.fields.IField;

public interface IForm {
	List<IField> getAllFields();
	List<IField> getMandatoryFields();
	IField getFieldByName(String fieldName);
}
