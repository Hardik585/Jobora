import { Avatar, TextInput } from "@mantine/core";
import { IconSearch } from "@tabler/icons-react";

const DreamJob = () => {
    return (
        <div className="flex items-center px-20">
            <div className="flex flex-col w-[45%] gap-4">
                <div className="text-6xl font-bold leading-tight text-mine-shaft-200 [&>span]:text-emerald-400">
                    Find The <span >Dream Job</span>  That Fit Your Life
                </div>
                <div className="text-mine-shaft-100 text-lg">
                    Search Your Dream Job While The Go With the Best Job Search Web Platform Available
                </div>
                <div className="flex gap-3 mt-5">
                    <TextInput className="bg-mine-shaft-900 rounded-lg p-1 px-3 text-mine-shaft-50 [&_input]:text-mine-shaft-50!" variant="unstyled" label="Job Title" placeholder="Software Engineer" />
                    <TextInput className="bg-mine-shaft-900 rounded-lg p-1 px-3 text-mine-shaft-50 [&_input]:text-mine-shaft-50!" variant="unstyled" label="Job Type" placeholder="Fulltime" />
                    <div className="flex items-center justify-center p-1 bg-emerald-400 rounded-lg w-20 h-full hover:bg-emerald-700 text-mine-shaft-100">
                        <IconSearch className="h-[85%] w-[85%]" />
                    </div>
                </div>
            </div>
            <div className="w-[55%] flex items-center justify-center">
                <div className="w-[30rem] relative">
                    <img src="./images/Boy.png" alt="boy" />
                    <div className="w-fit absolute border border-emerald-400 rounded-lg p-2 backdrop-blur-lg -right-10 top-[50%]">
                        <div className="text-center mb-1 text-mine-shaft-100 text-sm">20k+ got jobs</div>
                        <Avatar.Group>
                            <Avatar src="./images/avatar.png" />
                            <Avatar src="./images/avatar1.png" />
                            <Avatar src="./images/avatar2.png" />
                            <Avatar>+9K</Avatar>
                        </Avatar.Group>
                    </div>
                    <div className="w-fit absolute border border-emerald-400 rounded-lg p-2 backdrop-blur-lg -left-5 top-[29%] flex flex-col gap-2">
                        <div className="flex gap-2 items-center">
                            <div className="w-10 h-10 p-1 bg-mine-shaft-800 rounded-lg">
                                <img src="./images/Google.png" alt="google" />
                            </div>
                            <div className="text-sm text-mine-shaft-100">
                                <div>SoftwareEngineer</div>
                                <div className="text-mine-shaft-200 text-xs">New York</div>
                            </div>
                        </div>
                        <div className="flex gap-1 justify-around text-mine-shaft-200 text-xs">
                            <span>1 day Ago</span>
                            <span>120 Applicants</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DreamJob;