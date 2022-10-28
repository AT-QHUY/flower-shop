import React from 'react'
import {Box, Link} from '@mui/material'
import FacebookIcon from '@mui/icons-material/Facebook';
import GitHubIcon from '@mui/icons-material/GitHub';
import EmailIcon from '@mui/icons-material/Email';

export const Footer = () => {
  return (
    <Box boxSizing={"border-box"} display={"flex"} justifyContent={"space-between"}  height={"200px"} sx={{backgroundColor:'#1A1917'}} color={"#FFFFFF"} marginTop={"80px"} padding={"80px 400px"}>
        <Link color="#ffebee"><FacebookIcon fontSize='large' /></Link>
        <Link color="#ffebee"><GitHubIcon fontSize='large' /></Link>
        <Link color="#ffebee"> <EmailIcon fontSize='large' /></Link> 
    </Box>
  )
}

