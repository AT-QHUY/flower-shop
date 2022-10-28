import React from 'react'
import {TextField,StandardTextFieldProps} from '@mui/material'



interface InputFieldProps extends StandardTextFieldProps{

}

const InputField = (props: InputFieldProps) => {
  return (
    <TextField {...props}/>
  )
}

export default InputField