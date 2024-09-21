module com.javanotepad {
	requires javafx.fxml;
	requires javafx.controls;
	requires transitive javafx.graphics;

	opens com.javanotepad;
	opens com.javanotepad.controllers;
	opens com.javanotepad.events;
	opens com.javanotepad.service;
	opens com.javanotepad.util.enums;

	exports com.javanotepad;
	exports com.javanotepad.controllers;
	exports com.javanotepad.events;
	exports com.javanotepad.service;
	exports com.javanotepad.util.enums;
}