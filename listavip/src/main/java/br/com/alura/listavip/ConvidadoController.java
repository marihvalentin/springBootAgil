package br.com.alura.listavip;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvidadoController
{
    @Autowired
    private ConvidadoRepository repository;

    @RequestMapping("/")
   public String index()
   {
       return "index";
   }

   @RequestMapping("listaconvidados")
    public String listaConvidados(Model model)
    {
        Iterable<Convidado> convidados = repository.findAll();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone, Model model)
    {
        //variável da entidade do Convidado através dos parametros declarados acima
        Convidado novoConvidado = new Convidado(nome, email, telefone);

        //comando que salva e envia os dados preenchidos do novo convidado para o banco de dados
        repository.save(novoConvidado);

        Iterable<Convidado> convidados = repository.findAll();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }
}


