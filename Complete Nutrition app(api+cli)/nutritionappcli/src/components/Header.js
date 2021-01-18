import React from 'react';



class Header extends React.Component{
    render(){
        return(
            <div>
                
  <nav className="navbar navbar-expand-sm bg-success navbar-dark">
        <div className="container">
        <a className="nav-link " href="register.html">
                            
                Nutrition App
                
            </a>
         
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                <span className="navbar-toggler-icon" />
            </button>

            <div className="collapse navbar-collapse" id="mobile-nav">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                    <a className="nav-link" href="/nutritionplan">
                            Nutrition Plan
                    </a>
                    </li>
                    <li className="nav-item">
                    <a className="nav-link" href="/dietplan">
                            Diet Plan
                    </a>
                    </li>
                    <li className="nav-item">
                    <a class="nav-link" href="/weightlog">
                            Weight Log
                    </a>
                    </li>
                     <li className="nav-item">
                    <a className="nav-link" href="/payment">
                            Payment
                    </a>
                    </li>
                </ul>
                

                <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <a className="nav-link " href="logout.html">
                            Logout
                        </a>
                    </li>
                </ul>
               
            </div>
        </div>
    </nav>
    
            </div>
            
        );
    }
}
export default Header;