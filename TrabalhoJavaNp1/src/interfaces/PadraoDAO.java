/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

public interface PadraoDAO {
    public boolean salvarAtual();
    public boolean atualizarAtual();
    public boolean deletarAtual();
    public boolean deletarByKey(int key);
    public Object buscarByKey(int key);
    public List<Object> buscarTodos();
}
