import React from 'react';
import { Link } from 'react-router-dom';
import logo1 from './logo1.png';

class HeaderImage extends React.Component{
    render(){
        return(
            <div>
                
                <div><img className="photo" src={logo1} alt="Logo1" /></div>
    
            </div>
            
        );
    }
}
export default HeaderImage;