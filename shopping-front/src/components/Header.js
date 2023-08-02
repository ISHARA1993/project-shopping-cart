/** @format */

const Header = () => {
  return (
    <header
      id='header'
      className='fixed-top d-flex align-items-center header-transparent'>
      <div className='container d-flex align-items-center'>
        <div className='logo mr-auto'>
          <h1 className='text-light'>
            <a href='index.html'>
              <span>CrickBurger</span>
            </a>
          </h1>
          {/* Uncomment below if you prefer to use an image logo */}
          {/* <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>*/}
        </div>
        <nav className='nav-menu d-none d-sm-block'>
          <ul>
            <li className='active'>
              <a href='index.html'>Home</a>
            </li>
            <li>
              <a href='#about'>About</a>
            </li>
            <li>
              <a href='#menu'>Menu</a>
            </li>
            {/* <li><a href="#specials">Specials</a></li>
          <li><a href="#events">Events</a></li>
          <li><a href="#chefs">Chefs</a></li>
          <li><a href="#gallery">Gallery</a></li> */}
            <li>
              <a href='#contact'>Contact</a>
            </li>
            {/* <li class="book-a-table text-center">
            <a href="#book-a-table">Book a table</a>
          </li> */}
          </ul>
        </nav>
        {/* .nav-menu */}
      </div>
    </header>
  );
};

export default Header;
