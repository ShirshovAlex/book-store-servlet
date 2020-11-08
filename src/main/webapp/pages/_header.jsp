<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Book Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.isGuest}">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello Guest</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/registration">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/authorization">Authorization</a>
                </li>
            </c:if>
            <c:if test="${!sessionScope.isGuest}">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1"
                       aria-disabled="true">Hello ${sessionScope.user.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/account">Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/logout">Logout</a>
                </li>
            </c:if>

            <c:if test="${sessionScope.isAdmin}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Author menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                        <a class="dropdown-item" href="/author/save">Save author</a>
                        <a class="dropdown-item" href="/author/deleteById">Delete author by id</a>
                        <a class="dropdown-item" href="/author/delete">Delete author</a>
                        <a class="dropdown-item" href="/author/updateName">Update author name</a>
                        <a class="dropdown-item" href="/author/findAll">Find all</a>
                        <a class="dropdown-item" href="/author/findById">Find by id</a>
                        <a class="dropdown-item" href="/author/findAuthorByName">Find by name</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Book menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <a class="dropdown-item" href="/book/save">Save</a>
                        <a class="dropdown-item" href="/book/deleteBookById">Delete book by id</a>
                        <a class="dropdown-item" href="/book/deleteBookByName">Delete book by name</a>
                        <a class="dropdown-item" href="/book/updateTitleBook">Update tittle by id</a>
                        <a class="dropdown-item" href="/book/updateDescBook">Update description by id</a>
                        <a class="dropdown-item" href="/book/updateAuthorBook">Update author by id</a>
                        <a class="dropdown-item" href="/book/updatePriceBook">Update price by id</a>
                        <a class="dropdown-item" href="/book/findAll">Find all</a>
                        <a class="dropdown-item" href="/book/findByTitle">Find by title</a>
                        <a class="dropdown-item" href="/book/findByAuthor">Find by author</a>
                        <a class="dropdown-item" href="/book/findByPrice">Find by price</a>
                        <a class="dropdown-item" href="/book/findById">Find by id</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Order menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                        <a class="dropdown-item" href="/order/save">Save</a>
                        <a class="dropdown-item" href="/order/deleteById">Delete by id</a>
                        <a class="dropdown-item" href="/order/deleteByOrder">Delete by order</a>
                        <a class="dropdown-item" href="/order/updateStatus">Update status</a>
                        <a class="dropdown-item" href="/order/updateOrderAddress">Update address</a>
                        <a class="dropdown-item" href="/order/updateStore">Update store</a>
                        <a class="dropdown-item" href="/order/changeOrderType">Update order type</a>
                        <a class="dropdown-item" href="/store/updateAllBooks">Update all books</a>
                        <a class="dropdown-item" href="/order/addBookByOrder">add book by id</a>
                        <a class="dropdown-item" href="/order/findBookByOrder">find books by id</a>
                        <a class="dropdown-item" href="/order/findById">find order by id</a>
                        <a class="dropdown-item" href="/orders/findAllOrders">find all orders</a>
                        <a class="dropdown-item" href="/order/findAllByUser">find all orders by user</a>
                        <a class="dropdown-item" href="/order/findAllByStore">find all orders by store</a>
                        <a class="dropdown-item" href="/orders/findByAddress">find all orders by address</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Store menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                        <a class="dropdown-item" href="/store/save">save store</a>
                        <a class="dropdown-item" href="/store/deleteById">delete by id</a>
                        <a class="dropdown-item" href="/store/deleteByStore">delete by store</a>
                        <a class="dropdown-item" href="/store/updateAddress">update address</a>
                        <a class="dropdown-item" href="/store/getAll">get all</a>
                        <a class="dropdown-item" href="/store/getById">get by id</a>
                        <a class="dropdown-item" href="/store/getByStreet">get by street</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        User menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                        <a class="dropdown-item" href="/user/save">add user</a>
                        <a class="dropdown-item" href="/user/updateName">update name</a>
                        <a class="dropdown-item" href="/user/updatePass">update password</a>
                        <a class="dropdown-item" href="/user/updateRole">update role</a>
                        <a class="dropdown-item" href="/user/updateAddress">update address</a>
                        <a class="dropdown-item" href="/user/removeByUser">remove by user</a>
                        <a class="dropdown-item" href="/user/removeByLogin">remove by login</a>
                        <a class="dropdown-item" href="/user/removeById">remove by id</a>
                        <a class="dropdown-item" href="/user/findAll">find all</a>
                        <a class="dropdown-item" href="/user/findByLogin">find by login</a>
                        <a class="dropdown-item" href="/user/findByName">find by name</a>
                        <a class="dropdown-item" href="/user/findById">find by id</a>
                        <a class="dropdown-item" href="/user/findByRole">find by role</a>

                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown6" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Category menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                        <a class="dropdown-item" href="/category/save">add category</a>
                        <a class="dropdown-item" href="/category/deleteById">Delete category by id</a>
                        <a class="dropdown-item" href="/category/deleteByName">Delete category by name</a>
                        <a class="dropdown-item" href="/category/findAll">Find all categories</a>
                        <a class="dropdown-item" href="/category/findByName">Find category by name</a>
                        <a class="dropdown-item" href="/category/updateName">Update name</a>
                    </div>
                </li>
            </c:if>
        </ul>
        <div class="dropdown mr-3">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Category
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach items="${requestScope.categories}" var="category">
                    <a class="dropdown-item" href="/book/filter?id=${category.id}">${category.name}</a>
                </c:forEach>
            </div>
        </div>
        <form action="/search" method="post" class="form-inline my-2 my-lg-0">
            <input name="search" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>