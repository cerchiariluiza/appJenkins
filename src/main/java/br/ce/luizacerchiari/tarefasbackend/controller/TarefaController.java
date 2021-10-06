package br.ce.luizacerchiari.tarefasbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ce.luizacerchiari.tarefasbackend.utils.DateUtils;
import br.ce.luizacerchiari.tarefasbackend.utils.ValidationException;
import br.ce.luizacerchiari.tarefasbackend.model.Tarefas;
import br.ce.luizacerchiari.tarefasbackend.repo.TarefasRepo;

@RestController
@RequestMapping(value ="/todo")
public class TarefaController {

	@Autowired
	private TarefasRepo todoRepo;
	
	@GetMapping
	public List<Tarefas> findAll() {
		return todoRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Tarefas> save(@RequestBody Tarefas todo) throws ValidationException {
		if(todo.getTarefa() == null || todo.getTarefa() == "") {
			throw new ValidationException("Fill the Tarefa description");
		}
		if(todo.getDueDate() == null) {
			throw new ValidationException("Fill the due date");
		}
		if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
			throw new ValidationException("Due date must not be in past");
		}
		Tarefas saved = todoRepo.save(todo);
		return new ResponseEntity<Tarefas>(saved, HttpStatus.CREATED);
	}
}
