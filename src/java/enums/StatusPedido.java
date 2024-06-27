/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author SouthSystem
 */
public enum StatusPedido {
    PEDIDO_FEITO(1),
    EM_ESPERA(2),
    PRONTO(3);
    
    private final int codigo;
    
    private StatusPedido(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }
}
