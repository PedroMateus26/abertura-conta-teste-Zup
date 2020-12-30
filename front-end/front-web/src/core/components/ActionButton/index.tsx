import React from 'react';
import './styles.css';

type Props={
    title:string;
    onClick?:(event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => any;
}

const ActionButton=({title,onClick}:Props)=>(
    <button className="act-btn-container" onClick={onClick}>
        <h1 className="act-btn-text">{title}</h1>
    </button>
)

export default ActionButton;
