package br.com.produtos.impacta.transportlayers.controller;

import br.com.produtos.impacta.entities.ProdutoEntity;
import br.com.produtos.impacta.interactors.ProdutoUseCase;
import br.com.produtos.impacta.interactors.mapper.ProdutoMapper;
import br.com.produtos.impacta.transportlayers.request.CadastroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private ProdutoUseCase produtoUseCase;

	private static final ProdutoMapper PRODUTO_MAPPER = ProdutoMapper.INSTANCE;

	@GetMapping("/")
	public String index() {
		return "cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid CadastroRequest cadastroRequest, RedirectAttributes attr, BindingResult result) {
		produtoUseCase.cadastrar(PRODUTO_MAPPER.map(cadastroRequest));
		return "redirect:/";
	}

	@GetMapping("/home")
	public String home() {
		return "cadastrar";
	}

	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("produtos", produtoUseCase.consultar());
		mv.setViewName("/consultar");
		return mv;
	}

	@GetMapping("/produtos/find/{idProduto}")
	@ResponseBody
	public ProdutoEntity consultarById(@PathVariable("idProduto") Long idProduto) {
		return produtoUseCase.consultarById(idProduto);
	}

	@PutMapping("/produtos/update/{idProduto}")
	@ResponseBody
	public ResponseEntity<?> alterarProduto(
			@PathVariable("idProduto") Long idProduto,
			@RequestBody ProdutoEntity produto) {

		try {
			produto.setIdProduto(idProduto);
			produtoUseCase.alterarProduto(produto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao atualizar produto: " + e.getMessage());
		}
	}

	@DeleteMapping("/produtos/deletar/{idProduto}")
	public ResponseEntity<?> deletarById(@PathVariable("idProduto") Long idProduto) {
		try {
			produtoUseCase.deletarProduto(idProduto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao deletar produto: " + e.getMessage());
		}
	}


}
