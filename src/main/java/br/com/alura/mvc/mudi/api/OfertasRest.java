package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {


    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao){

        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(!pedidoBuscado.isPresent()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);

        pedidoRepository.save(pedido);

        return nova;

        }

        // PODERIA SER:

//    @RestController
//    @RequestMapping("/api/ofertas")
//    public class OfertasRest {
//
//        @Autowired
//        private PedidoRepository pedidoRepository;
//
//        @PostMapping
//        public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
//
//            //implementação omitida
//
//            return ResponseEntity.ok().body(nova);
//        }
//    }
//



    }


