package br.ce.luizacerchiari.tarefasbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ce.luizacerchiari.tarefasbackend.model.Tarefas;

public interface TarefasRepo extends JpaRepository<Tarefas, Long>{

}
