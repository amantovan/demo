package com.example.demo.business;

import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteVendedor;
import com.example.demo.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistribuicaoBusiness {

    @Autowired
    VendedorBusiness vendedorBusiness;

    @Autowired
    ClienteBusiness clienteBusiness;

    public List<ClienteVendedor> distribuir(){
        List<ClienteVendedor> distribuicoes= new ArrayList<>();

        for (Cliente cliente: clienteBusiness.listarTodos()) {

            ClienteVendedor clienteVendedor = new ClienteVendedor();
            clienteVendedor.setCodCliente(cliente.getId());
            clienteVendedor.setRazaoSocial(cliente.getRazaoSocial());

            double latC = Double.parseDouble(cliente.getPosicaoGeografica().getLatitude());
            double lonC = Double.parseDouble(cliente.getPosicaoGeografica().getLongitude());
            double distNova;
            double distMenor = 99999999;

            Vendedor vendedorMaisProximo = null;
            for (Vendedor vendedor: vendedorBusiness.listarTodos()) {
                double latV = Double.parseDouble(vendedor.getPosicaoGeografica().getLatitude());
                double lonV = Double.parseDouble(vendedor.getPosicaoGeografica().getLongitude());
                distNova = distance(latC, latV, lonC, lonV);

                if (distNova < distMenor){
                    distMenor = distNova;
                    vendedorMaisProximo = vendedor;
                }
            }
            if (vendedorMaisProximo!=null) {
                clienteVendedor.setCodVendedor(vendedorMaisProximo.getId());
                clienteVendedor.setNomeVendedor(vendedorMaisProximo.getNome());
                clienteVendedor.setDistancia(distMenor);
            }
            distribuicoes.add(clienteVendedor);
        }
        return distribuicoes;
    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters


        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
