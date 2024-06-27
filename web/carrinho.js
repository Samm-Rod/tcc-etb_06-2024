/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function finalizarPedido() {
    const cartItems = document.querySelectorAll('.cart-item');
    let cartData = [];

    cartItems.forEach(item => {
        cartData.push({
            item: item.querySelector('.cart-item-info span:first-child').textContent,
            price: item.querySelector('.cart-item-info span:nth-child(2)').textContent.replace('R$ ', ''),
            quantidade: parseInt(item.querySelector('span[id^="quantidade"]').textContent)
        });
    });

    localStorage.setItem('cartData', JSON.stringify(cartData));
    window.location.href = 'pagamento.jsp';
}

function remove(){
    
}

function excluirItem(itemId) {
    const itemToRemove = document.getElementById(itemId);
    itemToRemove.remove();
    atualizarTotal();
}

function alterarQuantidade(itemId, quantidade) {
    const quantidadeElement = document.getElementById(`quantidade-${itemId.split('-')[2]}`);
    let novaQuantidade = parseInt(quantidadeElement.textContent) + quantidade;

    if (novaQuantidade < 1) {
        novaQuantidade = 1; 
    }

    quantidadeElement.textContent = novaQuantidade;
    atualizarTotal();
}

function atualizarTotal() {
    const cartItems = document.querySelectorAll('.cart-item');
    let total = 0;

    cartItems.forEach(item => {
        const preco = parseFloat(item.querySelector('.cart-item-info span:nth-child(2)').textContent.replace('R$ ', ''));
        const quantidade = parseInt(item.querySelector('.cart-item-actions span[id^="quantidade"]').textContent);
        total += preco * quantidade;
    });

    const cartTotalElement = document.querySelector('.cart-total');
    cartTotalElement.textContent = `Total: R$ ${total.toFixed(2)}`;
}