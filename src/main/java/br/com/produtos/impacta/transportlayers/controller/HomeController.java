package br.com.produtos.impacta.transportlayers.controller;

import br.com.produtos.impacta.interactors.ProdutoUseCase;
import br.com.produtos.impacta.interactors.mapper.ProdutoMapper;
import br.com.produtos.impacta.transportlayers.request.CadastroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("produtos", produtoUseCase.consultar());
		mv.setViewName("/consultar");
		return mv;
	}

}
