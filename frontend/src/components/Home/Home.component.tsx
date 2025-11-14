import Header from "../Header/Header.component";
import Companines from "../LandingPage/Companies.component";
import DreamJob from "../LandingPage/DreamJob.component";

const Home = () => {
    return (
        <div className="min-h-screen bg-stone-800 font-['poppins']">
            <Header />
            <DreamJob />
            <Companines/>
        </div>
    )
}

export default Home;