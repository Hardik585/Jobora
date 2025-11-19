import Header from "../Header/Header.component";
import Companines from "../LandingPage/Companies.component";
import DreamJob from "../LandingPage/DreamJob.component";
import JobCategory from "../LandingPage/JobCategory.component";

const Home = () => {
    return (
        <div className="min-h-screen bg-stone-800 font-['poppins']">
            <Header />
            <DreamJob />
            <Companines/>
            <JobCategory/>
        </div>
    )
}

export default Home;