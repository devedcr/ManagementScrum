import { Link } from 'react-router-dom';
import scrumBoard from '../../../assets/image/scrumBoard.png';
import wave from '../../../assets/image/wave.png';
import { Animated } from "react-animated-css";

export function Login() {
    return (
        <div className="relative bg-background  h-screen">


            <div className={"bg-primary p-4 border-none border"}>
                    <h1 className={"font-custom ml-20 text-4xl text-white font-extrabold"}>Management</h1>
                    <h1 className={'font-custom ml-20 text-4xl text-white font-extrabold'}>Proyect Scrum</h1>
            </div>

            <img className='w-full z-0' src={wave} alt="wave" />

            <img className={"absolute left-[8%] top-[45%] h-[200px]"} src={scrumBoard} alt="" />

            <div className='absolute right-[10%] top-[20%]'>
                <Animated animationIn="zoomIn" isVisible={true}>
                    <form action="" className='bg-white w-[420px] h-[400px] shadow-2xl p-10 rounded-2xl'>
                        <div>
                            <h3 className={"text-center text-3xl text-secondary font-extrabold"}>Login</h3>
                        </div>
                        <div className='my-3 w-full'>
                            <label htmlFor="">
                                <small className={"text-gray-400"}>email</small>
                            </label>
                            <input
                                type="email"
                                name='prueba'
                                placeholder='example@gmail.com'
                                className='text-gray-500  border-b-[1px] w-full p-1 focus:outline-none'
                            />
                        </div>
                        <div className='my-3 w-full'>
                            <label htmlFor="">
                                <small className={"text-gray-400"}>password</small>
                            </label>
                            <input
                                type="password"
                                name='prueba'
                                placeholder='********'
                                className='text-gray-500 border-b-[1px] w-full p-1 focus:outline-none'
                            />
                        </div>
                        <div className='my-8'>
                            <button className={"hover:scale-105 transition-all duration-300  hover:bg-primary w-full bg-secondary rounded-md p-3 text-white"}>Sing In</button>
                        </div>
                        <div>
                            <small className={"text-gray-400 block text-center"}>
                                <Link to={"/register"}>Dont' have account ? sing up</Link>
                            </small>
                        </div>
                    </form>
                </Animated>
            </div>
        </div>
    )
}
