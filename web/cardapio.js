/* global localtion, itemTotal */

// Função para alternar as abas
    function showTab(tabName) {
        const tabs = document.querySelectorAll('.tab-content');
        tabs.forEach(tab => {
            tab.classList.remove('active');
        });
        document.getElementById(tabName).classList.add('active');
    }
    
    
    function sendCart(link){
        localtion.href = (link);
    }

    let totalValue = 0;

    // Função para atualizar o total
    function updateTotal() {
        const totalElement = document.getElementById('total');
        totalElement.textContent = `Total: R$ ${totalValue.toFixed(2)}`;
    }

    // Função para adicionar ao carrinho
    function addToCart(itemName, itemPrice, qtyId, event) {
        event.stopPropagation();
        
        const existCardInLocalStorage = localStorage.getItem("cart")
        
        if (existCardInLocalStorage) {
            const parsedCart = JSON.parse(existCardInLocalStorage)
            const productExistByName = parsedCart.findIndex(({ itemName: name }) => name == itemName)
            
            if (productExistByName != -1) {     
                parsedCart[productExistByName].qtyId = parsedCart[productExistByName].qtyId + 1
                console.log(parsedCart)
                localStorage.setItem("cart", JSON.stringify(parsedCart));
            } else {
                parsedCart.push({ itemName, itemPrice, qtyId: 1, event })
                localStorage.setItem("cart", JSON.stringify(parsedCart));
            }
        } else {
            localStorage.setItem("cart", JSON.stringify([{ itemName, itemPrice, qtyId: 1, event }]));
        }
        
        const quantity = document.getElementById(qtyId).value;
        const cart = document.getElementById('cart');
        const newItem = document.createElement('li');
        const itemTotal = itemPrice * quantity;
        newItem.innerHTML = `${itemName} - R$${itemPrice.toFixed(2)} x ${quantity} = R$${itemTotal.toFixed(2)}`;
        const removeBtn = document.createElement('button');
        removeBtn.textContent = 'Remover';
        removeBtn.classList.add('remove-btn');
        removeBtn.onclick = function() {
            newItem.remove();
            totalValue -= itemTotal;
            updateTotal();
            if (cart.children.length === 0) {
                const emptyMessage = document.createElement('li');
                emptyMessage.textContent = 'Seu carrinho está vazio';
                cart.appendChild(emptyMessage);
            }
        };
        newItem.appendChild(removeBtn);
        cart.appendChild(newItem);
        
        // Remover a mensagem "Seu carrinho está vazio"
        const emptyMessage = cart.querySelector('li');
        if (emptyMessage && emptyMessage.textContent === 'Seu carrinho está vazio') {
            emptyMessage.remove();
        }

        // Atualizar o total
        totalValue += itemTotal;
        updateTotal();
        
        // Exibir o modal
        const modal = document.getElementById('myModal');
        modal.style.display = 'block';
        setTimeout(() => {
            modal.style.display = 'none';
        }, 2000);
    }
    
//    function setCart() {
//        const cartFromLS = localStorage.getItem("cart")
//                
//        if (cartFromLS) {
//            const parsedCart = JSON.parse(cartFromLS)
//            
//            const cart = document.getElementById('cart');
//            
//            
//            for (let i = 0; i < parsedCart.length; i++) {
//                const newItem = document.createElement('li');
//                const removeBtn = document.createElement('button');
//                removeBtn.textContent = 'Remover';
//                removeBtn.classList.add('remove-btn');
//                
//                const { itemName, itemPrice, qtyId } = parsedCart[i]
//               
//                const total = itemPrice * qtyId;
//                newItem.innerHTML = `${itemName} - R$${itemPrice.toFixed(2)} x ${qtyId} = R$${total.toFixed(2)}`;
//                newItem.appendChild(removeBtn);
//                cart.appendChild(newItem);
//
//            }
//           
//        }
//    }
    
//    window.onload = function(event) {
//        setCart()
//    }

    // Fechar o modal quando o usuário clica no "X"
//    document.querySelector('.close').onclick = function() {
//        document.getElementById('myModal').style.display = 'none';
//    }

    // Fechar o modal quando o usuário clica fora do conteúdo do modal
    window.onclick = function(event) {
        const modal = document.getElementById('myModal');
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }

    // Função para exibir as informações do pedido
    function showOrderInfo() {
        const cart = document.getElementById('cart');
        if (cart.children.length === 0 || (cart.children.length === 1 && cart.children[0].textContent === 'Seu carrinho está vazio')) {
            alert('Seu carrinho está vazio!');
            return;
        }
        
        const orderInfoModal = document.getElementById('orderInfoModal');
        orderInfoModal.style.display = 'block';
    }

    // Função para fechar o modal de informações do pedido
    function closeOrderInfoModal() {
        const orderInfoModal = document.getElementById('orderInfoModal');
        orderInfoModal.style.display = 'none';
    }

    // Função para finalizar o pedido
    function finalizeOrder() {
        const cpf = document.getElementById('cpf').value;
        const tableNumber = document.getElementById('table-number').value;
        const paymentMethod = document.getElementById('payment-method').value;

        if (!cpf || !tableNumber) {
            alert('Por favor, preencha o CPF e o número da mesa.');
            return;
        }

        // Exibir o modal de finalização de pedido
        const orderModal = document.getElementById('orderModal');
        orderModal.style.display = 'block';

        // Limpar o carrinho e campos de pagamento
        const cart = document.getElementById('cart');
        cart.innerHTML = '<li>Seu carrinho está vazio</li>';
        document.getElementById('cpf').value = '';
        document.getElementById('table-number').value = '';
        document.getElementById('payment-method').value = 'credito';

        // Resetar o total
        totalValue = 0;
        updateTotal();

        // Fechar o modal de informações do pedido
        closeOrderInfoModal();
    }

    // Fechar o modal de finalização de pedido
    function closeOrderModal() {
        const orderModal = document.getElementById('orderModal');
        orderModal.style.display = 'none';
    }
    function formatCPF(input) {
    // Remove caracteres não numéricos
    var cpf = input.value.replace(/\D/g, '');

    // Adiciona os pontos e traço conforme digitação
    if (cpf.length > 3) {
        cpf = cpf.substring(0, 3) + '.' + cpf.substring(3);
    }
    if (cpf.length > 7) {
        cpf = cpf.substring(0, 7) + '.' + cpf.substring(7);
    }
    if (cpf.length > 11) {
        cpf = cpf.substring(0, 11) + '-' + cpf.substring(11);
    }

    // Atualiza o valor do campo
    input.value = cpf;
}
function toggleCart() {
    const cartContent = document.getElementById('cartContent');
    cartContent.style.display = cartContent.style.display === 'none' ? 'block' : 'none';
}

function sendItem(id, qtd, valor, nome) {
    if (confirm('Item adicionado no carrinho!')) {
        location.href = 'gerenciar_pedidos.do?acao=carrinho&id=' + id + '&qtd=' + qtd + '&valor=' + valor + '&nome=' + nome;
    } else {
        alert('Não encontrado!');
    }
}
    
//    function confirmarExclusao(id, nome, valor, descricao, arqImg){
//                if(confirm('Deseja realmente excluir esse item '+nome+' ?')){
//                    location.href='gerenciar_item.do?acao=deletar&id='+id;        
//                }else{
//                    alert('Não encontrado !')
//                }
//    }


// Add carrinho gpt

    let cart = [];

    function addToCart(nome, valor, qtd, event) {
        event.preventDefault();
        let item = {
            nome: nome,
            valor: valor,
            qtd: document.getElementById(qtd).value,
            total: valor * document.getElementById(qtd).value
        }
        cart.push(item);
        updateCartUI();
        showModal();
    }

    function updateCartUI() {
        let cartList = document.getElementById('cart');
        let totalPrice = document.getElementById('total');
        cartList.innerHTML = '';

        if (cart.length === 0) {
            cartList.innerHTML = '<li>Seu carrinho está vazio</li>';
            totalPrice.textContent = 'Total: R$ 0,00';
            return;
        }

        let total = 0;
        cart.forEach(item => {
            total += item.total;
            let li = document.createElement('li');
            li.textContent = `${item.nome} - R$ ${item.valor} x ${item.qtd} = R$ ${item.total}`;
            cartList.appendChild(li);
        });
        totalPrice.textContent = `Total: R$ ${total.toFixed(2)}`;
    }

    function showModal() {
        let modal = document.getElementById("myModal");
        modal.style.display = "block";
        setTimeout(() => { modal.style.display = "none"; }, 2000);
    }

    function showOrderInfo() {
        let orderModal = document.getElementById("orderInfoModal");
        orderModal.style.display = "block";
    }

    function closeOrderInfoModal() {
        let orderModal = document.getElementById("orderInfoModal");
        orderModal.style.display = "none";
    }

    function finalizeOrder() {
        let cpf = document.getElementById("cpf").value;
        let tableNumber = document.getElementById("table-number").value;
        let paymentMethod = document.getElementById("payment-method").value;

        // Enviar dados para o servidor
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "finalizeOrder.do", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                alert("Pedido finalizado com sucesso!");
                // Limpar o carrinho
                cart = [];
                updateCartUI();
                closeOrderInfoModal();
            }
        };
        let orderData = {
            cpf: cpf,
            tableNumber: tableNumber,
            paymentMethod: paymentMethod,
            items: cart
        };
        xhr.send(JSON.stringify(orderData));
    }